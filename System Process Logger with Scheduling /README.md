# 🖥️ ProcMon - Process Monitor and Logger

ProcMon is a simple Python-based utility that scans all currently running processes on a system and logs important details such as Process ID, Name, Username, and Virtual Memory Usage (VMS). It's useful for monitoring, auditing, or understanding what processes are running at any given time.

---

## 📌 Features

- Scans all running processes using `psutil`.
- Logs process information into timestamped log files.
- Logs include:
  - Process ID (PID)
  - Process Name
  - Username of the process owner
  - Virtual Memory Size (VMS) in MB
- Log files are saved in a folder named `ProcMonLogs`.

---

## 🛠️ Requirements

- Python 3.6+
- [psutil](https://pypi.org/project/psutil/)

##  Install dependencies using pip:

  - pip install psutil

    ---
## 📂 Sample Log Output

    --------------------------------------------------------------------------------
                    ProcMon - Process Log
                    Log File created at: Fri Oct  3 12:00:00 2025
    --------------------------------------------------------------------------------
    
    {'pid': 1234, 'name': 'python.exe', 'username': 'user', 'vms': 52.25}
    {'pid': 5678, 'name': 'chrome.exe', 'username': 'user', 'vms': 130.75}
    
    --------------------------------------------------------------------------------

---
## 📁 Folder Structure

 <pre>
   procmon/
          │
          ├── procmon.py         # Main script file
          ├── ProcMonLogs/       # Automatically created to store logs
          └── README.md          # Project documentation
 </pre>

 ## 👨‍💻 Author
**Karan Jadhav**  
  - Developer | Data Structures Enthusiast | System Design Learner
  - [📧] (karanjadhav0027@gmail.com)


