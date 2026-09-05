# Demo scenarios

## Scenario A — transient failure
Aarav Retail · ₹4,200 · BANK_TIMEOUT

Expected: SMART_RETRY.

## Scenario B — customer action
Maya Foods · ₹12,500 · INSUFFICIENT_FUNDS

Expected: PAYMENT_NUDGE.

## Scenario C — overdue receivable
Northstar Labs · ₹48,000 · INVOICE_OVERDUE

Expected: B2B_CHASER.

## Scenario D — checkout abandonment
GlowKart · ₹6,400 · CHECKOUT_ABANDONED

Expected: CHECKOUT_RECOVERY.

## Scenario E — subscription
Acme SaaS · ₹15,900 · SUBSCRIPTION_FAILED

Expected: SUBSCRIPTION_RETRY.

## Scenario F — mandate
PixelCloud · ₹22,000 · MANDATE_FAILED

Expected: MANDATE_RETRY.

## Scenario G — risk block
Nova Health · ₹23,000 · FRAUD_SUSPECTED

Expected: STOP / blocked.

## Scenario H — exhausted retries
MetroHome · ₹5,800 · 3 previous attempts

Expected: STOP.
