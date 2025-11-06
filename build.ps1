param(
    [string]$JdkPath = $env:JAVA_HOME
)

if (-not $JdkPath -or $JdkPath -eq "") {
    Write-Host "JAVA_HOME is not set and no JDK path was provided. Please set JAVA_HOME or pass -JdkPath 'C:\path\to\jdk-21'" -ForegroundColor Yellow
    exit 2
}

$javac = Join-Path $JdkPath "bin\javac.exe"
$java = Join-Path $JdkPath "bin\java.exe"

if (-not (Test-Path $javac)) {
    Write-Host "Could not find javac at $javac" -ForegroundColor Red
    exit 3
}

Write-Host "Using JDK at: $JdkPath"
Write-Host "Compiling Java sources..."
& $javac *.java
if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilation failed with exit code $LASTEXITCODE" -ForegroundColor Red
    exit $LASTEXITCODE
}

Write-Host "Running Main..."
& $java Main
