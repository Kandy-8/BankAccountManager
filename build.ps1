try {
    $src = Join-Path $PSScriptRoot 'src'
    $out = Join-Path $PSScriptRoot 'out'

    if (!(Test-Path $src)) {
        Write-Error "Source folder '$src' not found."
        exit 1
    }

    if (!(Test-Path $out)) { New-Item -ItemType Directory -Path $out | Out-Null }

    Write-Host "Compiling Java sources to '$out' with --release 21..."
    $javac = 'javac'
    $files = Get-ChildItem -Path $src -Filter '*.java' -Recurse | ForEach-Object { $_.FullName }

    if ($files.Count -eq 0) {
        Write-Error "No Java source files found in '$src'."
        exit 1
    }

    $args = @('--release','21','-d',$out) + $files
    $proc = Start-Process -FilePath $javac -ArgumentList $args -NoNewWindow -PassThru -Wait
    if ($proc.ExitCode -ne 0) {
        Write-Error "javac failed with exit code $($proc.ExitCode)."
        exit $proc.ExitCode
    }

    Write-Host "Compilation succeeded. Running Main..."
    & java -cp $out Main
}
catch {
    Write-Error "Build script failed: $_"
    exit 1
}
