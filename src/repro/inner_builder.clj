(ns repro.inner-builder
  (:require
    [steffan-westcott.clj-otel.api.otel]
    [clojure.reflect])
  (:import
    (io.opentelemetry.api GlobalOpenTelemetry OpenTelemetry)))

(defn make-builder
  [_args]
  (def global ^OpenTelemetry (steffan-westcott.clj-otel.api.otel/get-global-otel!))
  (def meterBuilderBuilder (.build (.meterBuilder global "wot")))
  (def longBuilder (.counterBuilder meterBuilderBuilder "wotwot"))
  (def by-method-name (group-by :name (:members (clojure.reflect/reflect longBuilder))))
  (by-method-name 'setUnit)
  ; =>
  ;[#clojure.reflect.Method{:name setUnit,
  ;                         :return-type io.opentelemetry.api.metrics.LongCounterBuilder,
  ;                         :declaring-class io.opentelemetry.sdk.metrics.SdkLongCounter$Builder,
  ;                         :parameter-types [java.lang.String],
  ;                         :exception-types [],
  ;                         :flags #{:public :bridge :synthetic}}]
  (.setUnit longBuilder "unit")
  (println "Worked"))

#_ (make-builder nil)