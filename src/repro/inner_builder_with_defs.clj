(ns repro.inner-builder-with-defs
  (:require
    [steffan-westcott.clj-otel.api.otel]
    [clojure.reflect])
  (:import
    (io.opentelemetry.api GlobalOpenTelemetry OpenTelemetry)))

(def global ^OpenTelemetry  (steffan-westcott.clj-otel.api.otel/get-global-otel!))
(def meterBuilderBuilder (.build (.meterBuilder global "wot")))
(def longBuilder (.counterBuilder meterBuilderBuilder "wotwot"))
(def by-method-name (group-by :name (:members (clojure.reflect/reflect longBuilder))))
(println (by-method-name 'setUnit))
(.setUnit longBuilder "unit")

(defn make-builder
  [_args]
  (println "Worked, but I expect this to fail"))