package spec

import cc.vileda.openapi.dsl.get
import cc.vileda.openapi.dsl.info
import cc.vileda.openapi.dsl.openapiDsl
import cc.vileda.openapi.dsl.parameter
import cc.vileda.openapi.dsl.path
import cc.vileda.openapi.dsl.paths
import cc.vileda.openapi.dsl.schema
import io.swagger.v3.oas.models.OpenAPI
import java.math.BigDecimal
import java.util.UUID

val openApiSpec: OpenAPI = openapiDsl {

    info {
        title = "Priority Server"
        version = "0.0.1"
    }

    paths {
        path("/roots/{rootId}") {
            get {
                parameter {
                    name = "rootId"
                    `in` = "path"
                    required = true
                    schema<UUID>()
                }
                parameter {
                    name = "treeDepth"
                    `in` = "query"
                    required = false
                    schema<Int> {
                        minimum = BigDecimal(0)
                    }
                }
                parameter {
                    name = "queueLength"
                    `in` = "query"
                    required = false
                    schema<Int> {
                        minimum = BigDecimal(0)
                    }
                }
            }
        }
    }

}
