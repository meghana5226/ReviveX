# Technical architecture

## Agent responsibilities

### 1. Signal / Detection
Materializes unresolved revenue events.

### 2. Root Cause Agent
Maps event and failure signals to a controlled taxonomy.

### 3. Recovery Scorer
Estimates probability of recovery.

### 4. Intervention Optimizer
Compares candidate actions using expected net value.

### 5. Policy Guard
Applies merchant and safety constraints.

### 6. Action Executor
Runs only permitted simulated actions.

### 7. Outcome Recorder
Records actual recovered value.

### 8. Audit Ledger
Appends decision, policy, execution and outcome events.

## Production-grade design decisions

### Idempotency

Recommended production key:

`merchantId:paymentId:actionType:attemptNumber`

Persist it with a unique constraint before executing an external side effect.

### Outbox

Use an outbox table so:
1. business state
2. action intent
3. audit event

are committed atomically before publishing to a queue.

### Retry safety

Workers should use:
- exponential backoff
- bounded retries
- dead-letter queue
- idempotency keys

### AI boundary

LLM use should be limited to tasks where unstructured reasoning adds value:
- extracting invoice context
- classifying free-text payment/support signals
- generating compliant message variants

Numeric recovery probability and policy decisions should remain deterministic/calibrated and testable.

### Security

Never store:
- PAN
- CVV
- OTP
- bank passwords

Use tokenized payment references.

### Observability

Track:
- recovery probability calibration
- recovery rate
- recovered value
- action conversion
- policy-block rate
- cost per recovered rupee
- false-positive contact rate
- average attempts to recovery

## Data model

```text
PaymentEvent 1 ─── 1 RecoveryCase
RecoveryCase 1 ─── N AuditEvent
MerchantPolicy 1 ─── N PaymentEvent
RecoveryCase 1 ─── N RecoveryAction (production extension)
```
