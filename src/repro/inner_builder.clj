(ns repro.inner-builder
  (:require
    [steffan-westcott.clj-otel.api.otel]
    [clojure.reflect])
  (:import
    (io.opentelemetry.api GlobalOpenTelemetry OpenTelemetry)))

(defn make-builder
  [_args]
  (let [global ^OpenTelemetry (steffan-westcott.clj-otel.api.otel/get-global-otel!)
        meterBuilderBuilder (.build (.meterBuilder global "wot"))
        longBuilder (.counterBuilder meterBuilderBuilder "wotwot")]
    (.setUnit longBuilder "unit")
    (println "Worked")))

#_ (make-builder nil)