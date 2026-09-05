# Razorpay Test Mode

ReviveX has two execution modes. Demo mode is the default and requires no credentials. Test mode is opt-in.

## Environment

```powershell
$env:REVIVEX_MODE="razorpay_test"
$env:RAZORPAY_KEY_ID="rzp_test_xxx"
$env:RAZORPAY_KEY_SECRET="your_secret"
$env:RAZORPAY_WEBHOOK_SECRET="your_webhook_secret"
```

Razorpay's Payment Links API uses `POST /v1/payment_links`; amount is sent in currency subunits, and the response includes a Payment Link ID, short URL and status. (official docs: https://razorpay.com/docs/api/payments/payment-links/create-standard/)

## Safe demo sequence

1. Run the recovery batch.
2. Select an eligible case.
3. Execute the recovery action.
4. ReviveX creates a Test Mode Payment Link and marks the case `AWAITING_OUTCOME`.
5. Open the returned short URL.
6. Complete the Test Mode payment.
7. Click `RECONCILE` or call `POST /api/v1/recovery/reconcile`.
8. ReviveX fetches the Payment Link state.
9. Only a paid link with confirmed payment amount becomes `RECOVERED`.

Razorpay documents the Payment Link states and that payment details populate after successful payment. (official docs: https://razorpay.com/docs/api/payments/payment-links/create-standard/)

## Webhook

Expose:

```text
POST /api/v1/webhooks/razorpay
```

Configure the webhook secret and expose the endpoint from a staging environment. ReviveX validates `X-Razorpay-Signature` using HMAC-SHA256 over the raw body and ignores duplicate event IDs. Razorpay documents the same raw-body signature validation model. (see the official Razorpay webhook validation documentation: https://razorpay.com/docs/webhooks/validate-test/)

## Important

A created Payment Link is **not** a recovered payment. The dashboard intentionally separates pending/attempted value from actual confirmed recovery.
