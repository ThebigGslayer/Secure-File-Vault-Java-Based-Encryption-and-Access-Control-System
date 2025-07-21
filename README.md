# 🔐 Secure File Vault — Java-Based File Encryption System

**Secure File Vault** is a command-line security application written in Java that provides **file-level encryption** and **user authentication** to protect sensitive information.
The system uses industry-standard cryptography (AES encryption and PBKDF2 password hashing)
and consolidates all core functionality in a single Java module for easy deployment and demonstration.

---

## ✨ Key Capabilities

- **User Authentication System**
  - Register and log in with hashed credentials
  - Persistent storage of usernames and hashed passwords
- **AES File Encryption and Decryption**
  - Uses 128-bit AES encryption
  - File-level confidentiality based on user password
- **Password Hashing**
  - PBKDF2 with HMAC-SHA1 and salt
- **Command-Line Interface (CLI)**
  - Lightweight, cross-platform, and portable
- **No External Libraries Required**
  - Built entirely on Java's standard crypto libraries

---

## 🛠️ Tech Stack

| Component           | Details                        |
|---------------------|--------------------------------|
| Language            | Java (JDK 8 or above)          |
| Cryptography        | AES, PBKDF2WithHmacSHA1        |
| Interface           | CLI (Text-based console)       |
| Storage             | File-based (`users.txt`)       |
| Dependencies        | None (pure Java SE)            |

---

## 📂 Project Structure

SecureFileVault.java # Full application logic (single module)
users.txt # User credentials (generated at runtime)

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java Development Kit (JDK 8 or later)
- Terminal or command prompt

### 📦 Compilation


javac SecureFileVault.java
▶️ Run the Application
bash
Copy
Edit
java SecureFileVault
🧪 Example Workflow

===== Secure File Vault =====
1. Register
2. Login
Choose option: 1
Enter username: alice
Enter password: ********
Registration successful.

Login successful.

1. Encrypt File
2. Decrypt File
3. Exit
Choose option: 1
Enter path of file to encrypt: secret.txt
Enter output encrypted file path: secret.enc
Encryption complete.
🔐 Security Considerations
Control Area	Implementation
Password Security	PBKDF2 key derivation (static salt for demo)
File Encryption	AES-128 with SHA-256-derived key
User Access	Local credential verification
Data Integrity	Not included (can be added via MAC/HMAC)

Note: For production use, implement per-user random salts and secure credential storage (e.g., databases, keystores).

📈 Future Enhancements
🔁 Replace static salt with user-specific random salt

📊 Activity logging with timestamps

🖼️ GUI implementation with JavaFX or Swing

🧾 File integrity validation using HMAC

👥 Admin role with user/session management

📄 License
This project is licensed under the MIT License.
Feel free to use, modify, and distribute with proper attribution.

👨‍💻 Author
Saravana Priyan
Cybersecurity Practitioner | Java Developer
📎 GitHub: github.com/ThebigGslayer
📎 LinkedIn: www.linkedin.com/in/saravana0501


