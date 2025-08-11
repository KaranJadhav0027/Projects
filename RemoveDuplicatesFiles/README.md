
## 📄 Project Description

This script automates the process of identifying and deleting **duplicate files** in a specified directory. It uses **MD5 checksum** to detect duplicates, logs all deleted files in a `.log` file, and **automatically emails** the log to a given email address at **scheduled time intervals**.

---

## 🧰 Features

- ✅ Recursively scans any given directory
- ✅ Detects duplicate files via checksum (MD5)
- ✅ Deletes all duplicates, keeping only one
- ✅ Generates a log file with file names and timestamps
- ✅ Emails the log file to the specified address
- ✅ Fully automated with scheduled time intervals

---

## 🖥️ Command Line Usage

python remove_duplicates.py <DirectoryPath> <TimeInMinutes> <ReceiverEmail>

##📌 Example:
python remove_duplicates.py "D:\MyFolder" 10 example@gmail.com

python remove_duplicates.py --h     # Displays help information
python remove_duplicates.py --u

##🆘 Help & Usage Flags
  python remove_duplicates.py --h     # Displays help information
  python remove_duplicates.py --u     # Shows usage instructions

##📁 Sample Log Output
  ------------------------------------------------------
This is a log file of Marvellous Automation Script
This is a Directory cleaner Script
------------------------------------------------------
C:\Users\Example\Documents\duplicate1.txt
C:\Users\Example\Documents\duplicate2.pdf
------------------------------------------------------
Total Execution time is : 0.45678 seconds
------------------------------------------------------
File created at : Sun Aug 11 2025 12:45:32
------------------------------------------------------

##📤 Email Setup
 - sender_email = "youremail@gmail.com"
  -sender_password = "your_app_password"  # Use App Password, NOT regular password
  
##⏰ Schedule Execution
   The script uses the schedule library to run at your defined interval (in minutes). It continues running in the background unless stopped manually (Ctrl+C).

##🛠 Requirements
  - Python 3.x
  - Internet connection for sending email
##📂 Folder Structure
 remove_duplicates.py
 Demo/
 ├── MarvellousLog_<timestamp>.log
##📈 Future Improvements (Suggestions)
  -Logging using logging module instead of print()
  - Environment file for secure credentials
  - CSV/JSON formatted logs
  -Cloud file backup
  - GUI version (Tkinter or PyQt)

##👨‍💻 Author
    -Karan Jadhav
     📧 karanjadhav0027@gmail.com

