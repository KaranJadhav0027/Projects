"""#######################################################################################################

"This automation script accepts a directory name, time in minutes, and an email ID. It removes all duplicate
 files from the given directory, creates a list of the deleted duplicate file names, and sends the log file 
 to the provided email address."
##########################################################################################################"""

import os
import sys
import time
import hashlib
import schedule
import smtplib
import ssl
from email.message import EmailMessage

def CalculateCheckSum(path,BlockSize=1024):
    fobj=open(path,"rb")

    hobj=hashlib.md5()

    buffer=fobj.read(BlockSize)
    while(len(buffer)>0):
        hobj.update(buffer)
        buffer=fobj.read(BlockSize)

    fobj.close()

    return hobj.hexdigest()

def DirectoryWatcher(DirectoryName="Marvellous"):
    
    flag=os.path.isabs(DirectoryName) #Check the path

    if(flag ==False):
         DirectoryName=os.path.abspath(DirectoryName) #give the path (updeter)

    flag=os.path.exists(DirectoryName) #check the valid path

    if(flag==False):
         print("The path is invalid ")
         exit()
    
    flag=os.path.isdir(DirectoryName) #check its is Directory or not 
    
    if(flag==False):
         print("path is valid but the target is not a directory ")

    Files={}
    for FolderName,SunFolderNames,FileNames in os.walk(DirectoryName):
          for fname in FileNames:
             fname=os.path.join(FolderName,fname) 
             checksum=CalculateCheckSum(fname) 
             if checksum in Files:
               Files[checksum].append(fname)
             else:
               Files[checksum] = [fname]
    return Files

def DeleteDuplicate(Path="Marvellous"):
     StartTime=time.time()
     MyDict=DirectoryWatcher(Path)
     Result=list(filter(lambda x:len(x)>1,MyDict.values()))
     Count=0
     Cnt=0
     Files=[]
     
     for value in Result:
          for subvalue in value:
               Count=Count+1
               if(Count>1):
                    # print("Deleted file :",subvalue)
                    Files.append(subvalue)
                    os.remove(subvalue) 
                    Cnt=Cnt+1     
          Count=0
    
     print("Total Deleted File :",Cnt)
     
     EndTime=time.time()
     diff=EndTime-StartTime
     print("Total Execution time is :",diff)
     #  CreateLog(Files,diff)
     log_file = CreateLog(Files, diff)
     return log_file

    
def CreateLog(Files,diff):
    Dir="Demo"
    if not os.path.exists(Dir):
          os.makedirs(Dir)
    timestamp=time.ctime()

    fileName=os.path.join(Dir,"MarvellousLog %s.log" %(timestamp))
    
    fileName=fileName.replace(" ","_")
    fileName=fileName.replace(":","_")

    fobj=open(fileName,"w")
    
    Border="-"*54
    fobj.write(Border+"\n")
    fobj.write("This is a log file of Marvellous Automation Script\n")
    fobj.write("This is a Driectrory cleaner Script")
    fobj.write(Border+"\n")
    
    for F in Files:
          fobj.write(F+"\n")
    
    fobj.write(Border+"\n")
    fobj.write("Total Execution time is :\n"+str(diff)+"\n")
    fobj.write(Border+"\n")
    
    fobj.write(Border+"\n")
    fobj.write("File created at :\n"+timestamp+"\n")
    fobj.write(Border+"\n")

    return fileName

def SendMail(file_path,receiver_email):

    sender_email = "Mail1@gmail.com"
    sender_password = "xxxxxxxxxxxxxx"  
    subject = "Automation log mail"
    body = "Log file Send"

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

def main():
        Border="-"*54
        print(Border)
        print("-----------------Marvellous Automation----------------")
        print(Border)
        
        if(len(sys.argv)==2 ):
            if((sys.argv[1]=="--h") or (sys.argv[1]=="--H")):
                print("This application is used to perform Directory Cleaning and send the information to mail to log file")
                print("This is the automation script")

            elif((sys.argv[1]=="--u") or (sys.argv[1]=="--U")):
                print("Use the given script as ")
                print("ScriptName.py  NameOfDirectory Time Mail_ID")
                print("Please provide Valid Absolute path")
            
            else:
                print("Invalid number of Command line Arguments")
                print("Use the given flage as :")
                print("--h :Used to Display the help")
                print("--u: Used to Display the Usage")

        elif(len(sys.argv)==4 ):
                #  DeleteDuplicate(sys.argv[1])
                Dir=sys.argv[1]
                vel=int(sys.argv[2])
                mail=sys.argv[3]
                # schedule.every(vel).minutes.do(DeleteDuplicate,Dir,mail)
                schedule.every(vel).minutes.do(lambda: SendMail(DeleteDuplicate(Dir), mail))

                while True:
                    schedule.run_pending()
                    time.sleep(1)
        
        else:
            print("Invalid number of Command line Arguments")
            print("Use the given flage as :")
            print("--h :Used to Display the help")
            print("--u: Used to Display the Usage")
        
        print(Border)
        print("------------Thank you for using our Script------------")
        print("----------------Marvellous Infosystems----------------")
        print(Border)


if __name__=="__main__":
    main()