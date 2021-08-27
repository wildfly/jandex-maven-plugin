def jandexFile = new File(basedir, 'target/classes/META-INF/jandex.idx')
assert jandexFile.exists() : "File does not exist: ${jandexFile}"
assert jandexFile.length() > 0 : "File is empty: ${jandexFile}"

def logFile = new File(basedir, 'build.log')
def found = false
logFile.eachLine{line ->
    if (line.contains('Skipping index generation, everything is up to date.')) {
        found = true
    }
}
assert found : "Index generation has not been skipped: ${logFile}"