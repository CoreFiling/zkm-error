Minimal project for reproducing an error when running ZKM fro Gradle.

### Instructions

1. Set `ZKM_JAR_PATH` in [buildSrc/gradle.properties](buildSrc/gradle.properties) to the location of the ZKM jar (
   version 17.0 or later).
2. Run `./gradlew zkmTask`.

### Result

An error similar to the following occurs:

    ZKM: FATAL ERROR: Serious Errors detected during execution of 'obfuscate' statement. : ERROR: Method 'sample_b(java.lang.Object, java.lang.Object)' in class '/path/to/project/build/install/sample/lib/commons-lang3-3.9.jar!org/apache/commons/lang3/builder/EqualsBuilder.class' appears to be invalid (5) : 'Stack mismatch with types: Ljava/util/Set; I : 'analyzing the control flow of method 'isRegistered(java.lang.Object, java.lang.Object)' in class '/path/to/project/build/install/sample/lib/commons-lang3-3.9.jar!org/apache/commons/lang3/builder/EqualsBuilder.class' : 'sample_a/sample_a/sample_a/sample_a/sample_b/sample_f' (A)''
