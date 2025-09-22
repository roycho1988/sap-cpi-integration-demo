# SAP CPI Integration Demo

This repository demonstrates an end-to-end **SAP CPI integration**:  
JSON payload → Groovy script → IDoc-style XML → HTTP Receiver.  

The project is tested with **Postman** and includes runtime logs, screenshots, and artifacts.  
It also highlights potential **future enhancements** with Azure Data Factory, Azure Blob Storage, and GitHub Actions.


> Demo project: JSON → Groovy Script → IDoc-like XML → HTTP Receiver (Webhook.site)  
> Tested with Postman. Includes runtime log and screenshots.

---

## What this shows

- **SAP CPI iFlow** that accepts a JSON payload (ORDER05 sample)
- A **Groovy Script** (`Json2Idoc.groovy`) converts JSON → IDoc-style XML
- Message sent to an **HTTP Receiver** (Webhook.site mock endpoint)
- Tested with **Postman**
- Includes **runtime log** proving success

---

## Repo Structure
scripts/
└─ Json2Idoc.groovy
└─ Json2Idoc - reload.groovy (optional variant)

payloads/
└─ ORDERS05.json

logs/
└─ MessageLog-IDOC_IFLOW.txt

screenshots/
├─ Groovy Script code in CPI.png
├─ iFlow Design.png
├─ Message Monitor log → Success.png
└─ Postman test with JSON request + 200 OK response.png


---

## Screenshots

**iFlow Design**

![iFlow Design](iFlow%20Design.png)

**Groovy Script**

![Groovy Script](Groovy%20Script%20code%20in%20CPI.png)

**Monitor – Success**

![Monitor Success](Message%20Monitor%20log%20%E2%86%92%20Success.png)

**Postman test (200 OK)**

![Postman](Postman%20test%20with%20JSON%20request%20+%20200%20OK%20response.png)

---

## How to Run

1. Deploy the iFlow in **SAP CPI**.
2. Configure the **Receiver HTTP adapter** to point to your Webhook.site URL.
3. Use **Postman** → send `payloads/ORDERS05.json` to the CPI endpoint.
4. Check **Monitor → Message Processing** → should show ✅ *Completed*.
5. Confirm **Webhook.site** received the IDoc-style XML.

---

## Future Enhancements

- Extend demo with **Azure Data Factory** to orchestrate CPI calls.
- Store payloads & logs in **Azure Blob Storage**.
- Automate testing with **GitHub Actions**.




