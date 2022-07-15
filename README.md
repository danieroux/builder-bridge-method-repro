# What I see

```
$ java -version
openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment AdoptOpenJDK-11.0.11+9 (build 11.0.11+9)
OpenJDK 64-Bit Server VM AdoptOpenJDK-11.0.11+9 (build 11.0.11+9, mixed mode)
$ make fails
clj -X:fails
[#clojure.reflect.Method{:name setUnit, :return-type io.opentelemetry.api.metrics.LongCounterBuilder, :declaring-class io.opentelemetry.sdk.metrics.SdkLongCounter$Builder, :parameter-types [java.lang.String], :exception-types [], :flags #{:public :bridge :synthetic}}]
Execution error (IllegalArgumentException) at repro.inner-builder-with-defs/eval240 (inner_builder_with_defs.clj:13).
No matching method setUnit found taking 1 args for class io.opentelemetry.sdk.metrics.SdkLongCounter$Builder

Full report at:
/var/folders/45/d27gcvcn2dd1k4cjms_mdk6m0000gn/T/clojure-13850252137598920323.edn

make: *** [fails] Error 1
$ make succeeds
clj -X:succeeds
Worked
```