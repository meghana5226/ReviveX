# ReviveX — 5-minute judge pitch

## 0:00 — Hook

"Revenue leakage is not a single failure. It is a sequence of degraded payment states. ReviveX turns those states into measurable recovery actions."

## 0:25 — The product

"ReviveX is an agentic revenue recovery control plane. It detects the event, diagnoses the root cause, estimates recovery probability, optimizes expected net rupee recovery, applies policy, executes a bounded action, and stops automatically."

## 0:55 — What makes it different

"Most payment recovery systems ask: should I retry?

ReviveX asks: **which intervention creates the highest expected net recovery, and is it still worth doing?**"

Show the formula:

Expected Net Recovery = P(recovery) × amount − action cost − friction − risk penalty.

## 1:25 — Live batch

Click RUN RECOVERY BATCH.

Say:
"Notice that different revenue events produce different actions. This is not one retry rule."

## 1:55 — High-value B2B case

Open ₹48,000 overdue invoice.

Explain:
- root cause
- probability
- expected recovery
- B2B chaser
- merchant policy

Execute the simulated action.

Show the audit trail.

## 2:55 — Guardrail demo

Open the case with 3 previous attempts.

It stops.

Say:
"An autonomous system without stopping rules is a liability. ReviveX treats stopping as a first-class decision."

## 3:25 — Engineering depth

Show architecture:

Event → diagnosis → scoring → optimizer → policy → action → outcome → audit.

Mention:
- Java/Spring Boot
- JPA/PostgreSQL-ready
- deterministic reproducibility
- policy-first execution
- audit events
- synthetic action adapters
- explicit idempotency design for production evolution

## 4:00 — Money

Return to dashboard.

Focus on:
- expected net opportunity
- attempted value
- recovered value
- recovery rate
- safely stopped cases

Say:
"The product KPI is not AI accuracy. It is incremental recovered revenue under constraints."

## 4:30 — Production path

"At production scale, event ingestion becomes Kafka, recovery probability becomes a calibrated model, policy moves into OPA/Cedar, and action adapters connect to payment, CRM and messaging providers."

## 4:50 — Close

"ReviveX is a closed-loop recovery system: it knows what happened, what to do, what not to do, and how much money the decision actually recovered."
