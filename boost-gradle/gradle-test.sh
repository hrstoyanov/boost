./gradlew install check -Ptest.exclude="**/*15*" -Druntime=$RUNTIME -DruntimeVersion=$RUNTIME_VERSION --stacktrace --info --no-daemon
ls build/test-results/test/ >> out.txt
./gradlew wrapper --gradle-version 4.10
./gradlew install check -Ptest.include="**/*15*" -Druntime=$RUNTIME -DruntimeVersion=$RUNTIME_VERSION --stacktrace --info --no-daemon
ls build/test-results/test/ >> out.txt
cat out.txt
