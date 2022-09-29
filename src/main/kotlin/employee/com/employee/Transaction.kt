package employee.com.employee

import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    val id: Long,
    val amount: BigDecimal,
    val transactionTime: LocalDateTime,
    val reference: String
)