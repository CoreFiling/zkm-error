Minimal project for reproducing an error when running ZKM fro Gradle.

### Instructions

1. Set `ZKM_JAR_PATH` in [buildSrc/gradle.properties](buildSrc/gradle.properties) to the location of the ZKM jar (
   version 17.0 or later).
2. Run `./gradlew zkmTask`.

### Result

An error similar to one of the following occurs:

    ZKM: FATAL ERROR: Serious Errors detected during execution of 'obfuscate' statement. : ERROR: Method 'sample_b(java.lang.Object)' in class '/path/to/project/build/install/sample/lib/guava-31.1-jre.jar!com/google/common/collect/ImmutableSet$JdkBackedSetBuilderImpl.class' appears to be invalid (5) : 'Stack mismatch with types: I Lsample_a/sample_a/sample_a/sample_d/sample_ic; : 'analyzing the control flow of method 'add(java.lang.Object)' in class '/path/to/project/build/install/sample/lib/guava-31.1-jre.jar!com/google/common/collect/ImmutableSet$JdkBackedSetBuilderImpl.class' : 'sample_a/sample_a/sample_a/sample_d/sample_ic' (A)''

or

    ZKM: FATAL ERROR: Serious Errors detected during execution of 'obfuscate' statement. : ERROR: Method 'sample_a()' in class '/path/to/project/build/install/sample/lib/guava-31.1-jre.jar!com/google/common/util/concurrent/AbstractService$IsStartableGuard.class' appears to be invalid (5) : 'Inconsistent stack heights 2 1 : 'analyzing the control flow of method 'isSatisfied()' in class '/path/to/project/build/install/sample/lib/guava-31.1-jre.jar!com/google/common/util/concurrent/AbstractService$IsStartableGuard.class' : 'sample_a/sample_a/sample_a/sample_o/sample_a/sample_e3' (A)''
