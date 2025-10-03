##################################################################
# Project        : ProcMon - Process Monitor and Logger          #
# Description    : Scans all running processes and logs details  #
# Author         : Karan Jadhav                                  #
# Date           : 2025-09-18                                    #
##################################################################

import psutil
import os
import time

#########################################################################
# Function Name  : create_log                                           #
# Description    : Creates a timestamped log file with process details  #
# Parameters     : FolderName (str), Data (list of dict)                #
# Returns        : None                                                 #
#########################################################################
def create_log(FolderName, Data):
    if not os.path.exists(FolderName):
        os.mkdir(FolderName)
    
    timestamp = time.ctime()
    timestamp = timestamp.replace(" ", "")
    timestamp = timestamp.replace(":", "_")
    timestamp = timestamp.replace("/", "_")

    FileName = os.path.join(FolderName, "ProcMon_%s.log" % (timestamp))

    with open(FileName, "w") as fobj:
        Border = "-" * 80
        fobj.write(Border + "\n")
        fobj.write("\t\tProcMon - Process Log\n")
        fobj.write("\t\tLog File created at: " + time.ctime() + "\n")
        fobj.write(Border + "\n\n")

        for value in Data:
            fobj.write("%s\n" % value)

        fobj.write("\n" + Border + "\n")

###########################################################################
# Function Name  : process_scan                                           #
# Description    : Scans currently running processes and collects details #
# Parameters     : None                                                   #
# Returns        : list of dict (process details)                         #
###########################################################################
def process_scan():
    listprocess = []
    for proc in psutil.process_iter():
        try:
            info = proc.as_dict(attrs=['pid', 'name', 'username'])
            info['vms'] = proc.memory_info().vms / (1024 * 1024)
            listprocess.append(info)
        except (psutil.NoSuchProcess, psutil.AccessDenied, psutil.ZombieProcess):
            pass
    return listprocess

###############################################################
# Function Name  : main                                       #
# Description    : Entry point of the application             #
# Parameters     : None                                       #
# Returns        : None                                       #
###############################################################
def main():
    processes = process_scan()
    create_log("ProcMonLogs", processes)

if __name__ == "__main__":
    main()
