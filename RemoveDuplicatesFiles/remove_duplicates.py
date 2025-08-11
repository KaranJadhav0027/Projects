####=============================================================================####
#                      Duplicate File Remover & Email Automation Script              #
#                         Author: [Karan Jadhav]                                     #
#                           Last Updated: [1-07-2025]                                #
####=============================================================================####

"""
This automation script accepts:
1. Directory path
2. Time interval (in minutes)
3. Recipient email ID

It performs the following:
- Removes duplicate files using checksum
- Generates a log file with deleted file names
- Sends the log file to the specified email
- Schedules this operation every N minutes
"""

import os
import sys
import time
import hashlib
import schedule
import smtplib
import ssl
from email.message import EmailMessage

#=============================================================================#
#                         Calculate File Checksum                             #
# Calculates MD5 hash of the file content for duplicate detection             #
#=============================================================================#
def CalculateCheckSum(path, BlockSize=1024):
    fobj = open(path, "rb")
    hobj = hashlib.md5()
    buffer = fobj.read(BlockSize)
    while len(buffer) > 0:
        hobj.update(buffer)
        buffer = fobj.read(BlockSize)
    fobj.close()
    return hobj.hexdigest()

#=============================================================================#
#                            Directory Watcher                                #
# Walks through directory and maps checksums to file paths                    #
#=============================================================================#
def DirectoryWatcher(DirectoryName="Marvellous"):
    if not os.path.isabs(DirectoryName):
        DirectoryName = os.path.abspath(DirectoryName)

    if not os.path.exists(DirectoryName):
        print("The path is invalid.")
        exit()

    if not os.path.isdir(DirectoryName):
        print("Path is valid but not a directory.")

    Files = {}
    for FolderName, SubFolderNames, FileNames in os.walk(DirectoryName):
        for fname in FileNames:
            full_path = os.path.join(FolderName, fname)
            checksum = CalculateCheckSum(full_path)
            if checksum in Files:
                Files[checksum].append(full_path)
            else:
                Files[checksum] = [full_path]
    return Files

#=============================================================================#
#                            Delete Duplicates                                #
# Deletes files having same checksum, keeps only one                          #
#=============================================================================#
def DeleteDuplicate(Path="Marvellous"):
    StartTime = time.time()
    MyDict = DirectoryWatcher(Path)
    Result = list(filter(lambda x: len(x) > 1, MyDict.values()))
    Count = 0
    Cnt = 0
    Files = []

    for value in Result:
        for subvalue in value:
            Count += 1
            if Count > 1:
                Files.append(subvalue)
                os.remove(subvalue)
                Cnt += 1
        Count = 0

    print("Total Deleted Files:", Cnt)

    EndTime = time.time()
    diff = EndTime - StartTime
    print("Total Execution time is:", diff)

    log_file = CreateLog(Files, diff)
    return log_file

#=============================================================================#
#                              Create Log File                                #
# Logs deleted file names, execution time, and timestamp                      #
#=============================================================================#
def CreateLog(Files, diff):
    Dir = "Demo"
    if not os.path.exists(Dir):
        os.makedirs(Dir)

    timestamp = time.ctime()
    fileName = os.path.join(Dir, "MarvellousLog %s.log" % (timestamp))
    fileName = fileName.replace(" ", "_").replace(":", "_")

    fobj = open(fileName, "w")
    Border = "-" * 54

    fobj.write(Border + "\n")
    fobj.write("This is a log file of Marvellous Automation Script\n")
    fobj.write("This is a Directory cleaner Script\n")
    fobj.write(Border + "\n")

    for F in Files:
        fobj.write(F + "\n")

    fobj.write(Border + "\n")
    fobj.write("Total Execution time is :\n" + str(diff) + "\n")
    fobj.write(Border + "\n")
    fobj.write("File created at :\n" + timestamp + "\n")
    fobj.write(Border + "\n")

    return fileName

#=============================================================================#
#                             Send Email                                      #
# Sends log file as attachment to provided email address                      #
#=============================================================================#
def SendMail(file_path, receiver_email):
    sender_email = "Mail1@gmail.com"
    sender_password = "xxxxxxxxxxxxxx"
    subject = "Automation log mail"
    body = "Log file sent."

    try:
        msg = EmailMessage()
        msg["From"] = sender_email
        msg["To"] = receiver_email
        msg["Subject"] = subject
        msg.set_content(body)

        with open(file_path, "rb") as f:
            file_data = f.read()
            file_name = os.path.basename(file_path)

        msg.add_attachment(file_data, maintype="application", subtype="octet-stream", filename=file_name)

        context = ssl.create_default_context()
        with smtplib.SMTP("smtp.gmail.com", 587) as server:
            server.starttls(context=context)
            server.login(sender_email, sender_password)
            server.send_message(msg)

        print("Email sent successfully with the log file!")

    except Exception as e:
        print(f"Error sending email: {e}")

#=============================================================================#
#                               Main Function                                 #
# Handles arguments, schedules job, or shows help/usage info                  #
#=============================================================================#
def main():
    Border = "-" * 54
    print(Border)
    print("-----------------Marvellous Automation----------------")
    print(Border)

    if len(sys.argv) == 2:
        if sys.argv[1] in ("--h", "--H"):
            print("This application removes duplicate files and emails the log.")
            print("Usage: python remove_duplicates.py <DirectoryPath> <TimeInMinutes> <ReceiverEmail>")
        elif sys.argv[1] in ("--u", "--U"):
            print("Usage:")
            print("python remove_duplicates.py <DirectoryPath> <TimeInMinutes> <ReceiverEmail>")
            print("Please provide a valid absolute path.")
        else:
            print("Invalid flag. Use --h for help or --u for usage.")

    elif len(sys.argv) == 4:
        Dir = sys.argv[1]
        vel = int(sys.argv[2])
        mail = sys.argv[3]

        schedule.every(vel).minutes.do(lambda: SendMail(DeleteDuplicate(Dir), mail))

        while True:
            schedule.run_pending()
            time.sleep(1)

    else:
        print("Invalid number of command line arguments.")
        print("Use the following flags:")
        print("--h : Help")
        print("--u : Usage")

    print(Border)
    print("------------Thank you for using our Script------------")
    print("----------------Marvellous Infosystems----------------")
    print(Border)

#=============================================================================#
#                             Script Entry Point                              #
#=============================================================================#
if __name__ == "__main__":
    main()
