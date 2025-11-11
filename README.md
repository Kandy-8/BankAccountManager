# BankAccountManager — Java 21 upgrade notes

This repository contains a small Java CLI app in `src/`.

Goal: upgrade local runtime to Java 21 (latest LTS) and verify the project compiles and runs with Java 21.

Recommended steps (Windows / PowerShell):

1. Install a Java 21 JDK
   - Preferred: Eclipse Adoptium (Temurin) or another vendor that distributes JDK 21.
   - Download from: https://adoptium.net/ (choose Temurin 21) and run the installer.
   - Alternatively use a Windows package manager you trust (winget / scoop / choco) if available.

2. Set JAVA_HOME and update PATH (PowerShell example)

```powershell
# Replace with the actual install path of your JDK 21
[Environment]::SetEnvironmentVariable('JAVA_HOME','C:\Program Files\Eclipse Adoptium\jdk-21', 'User')
$newPath = "C:\Program Files\Eclipse Adoptium\jdk-21\bin;" + [Environment]::GetEnvironmentVariable('Path','User')
[Environment]::SetEnvironmentVariable('Path',$newPath,'User')
# Close and re-open your shell to pick up changes
```

3. Verify installation

```powershell
java -version
javac -version
```

You should see `java version "21"` or similar.

4. Compile and run the project (this repo includes `build.ps1` to help):

```powershell
.\build.ps1    # compiles with --release 21 and runs Main if build succeeds
```

Notes
- This project currently has no Maven/Gradle build file; it's plain `*.java` sources in `src/`.
- If you use CI (GitHub Actions), update workflow to use `distribution: temurin` and `java-version: '21'`.
- If you'd like, I can add a Maven `pom.xml` or Gradle build script and configure a GitHub Actions workflow that builds/tests using Java 21.

If you want me to proceed and install JDK 21 on your machine automatically, I attempted to use the automated upgrade tools but they require a paid plan and are not available in this environment — I can still provide step-by-step commands or add CI config and local build scripts. Tell me which you prefer.
