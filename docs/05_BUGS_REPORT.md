# 🐞BUGS REPORT

![Company logo](assets/company-logo.png)

AlexanderAndrade.Net Repository


> A simple bug reporter
>

## Table of Contents

- [Bug #1: Service: Get information per Satellite](#get).
- [Bug #2: Service: Post setting information for various satellites](#postvarious).
- [Bug #3: Service: Post setting information for a specific satellite](#postone).

## Bugs report

### Service: Get information per Satellite<a name="#get"></a>

| Status  | Severity | Environment   | Serenity Report                                                                                                                                                                                                |
|---------|----------|---------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 🟢 Open | 🔽 Low   | 💰 Production | 📊 <a href="https://htmlpreview.github.io/?https://github.com/AlexAndradeSan/mercadolibre/blob/main/target/site/serenity/1fbf80cae8c6c8e99b54da3b1e2b02a6e285fb7f5068912d5d7775ce4522fbf4.html">Serenity Report</a> |

**Description**

<table border="1" cellpadding="5" cellspacing="5">
<tr>
    <th>❌ Current situation</th>
    <td>The service allows you to search for information on non-existent satellites and also delivers information as if it were found.</td>
    </tr>
<tr>
    <th>✅ Expected situation</th>
    <td>The service should return a 404 (resource not found) response code and a message in the response body indicating the situation.</td>
</tr>
<tr>
    <th>👩🏽‍💻 How to reproduce it</th>
    <td>Query the service using the names (without quotes): "vader", "*", "$" e "=".
    </td>
</tr>
</table>

### Service: Post setting information for various satellites<a name="#postvarious"></a>

| Status  | Severity | Environment   | Serenity Report                                                                                                                                                                                                |
|---------|----------|---------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 🟢 Open | ↗️ Medium     | 💰 Production | 📊 <a href="https://htmlpreview.github.io/?https://github.com/AlexAndradeSan/mercadolibre/blob/main/target/site/serenity/5a40d88946d4ec3420d56d303be62d823adcf6d3dedb02b5f2d694478e6c58b7.html">Serenity Report</a> |

**Description**

<table border="1" cellpadding="5" cellspacing="5">
<tr>
    <th>❌ Current situation</th>
    <td>The service not control the bad requests, that's allows You to make unnecessary queries to the database, returning a 404 (not found) http status.</td>
    </tr>
<tr>
    <th>✅ Expected situation</th>
    <td>The service must prevent unnecessary queries to the database and return a 400 (bad requests) http status.</td>
</tr>
<tr>
    <th>👩🏽‍💻 How to reproduce it</th>
    <td>Query the service using an empty body request.
    </td>
</tr>
</table>

### Service: Post setting information for a specific satellite<a name="#postone"></a>

| Status  | Severity | Environment   | Serenity Report                                                                                                                                                                                                |
|---------|----------|---------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 🟢 Open | ↗️ Medium     | 💰 Production | 📊 <a href="https://htmlpreview.github.io/?https://github.com/AlexAndradeSan/mercadolibre/blob/main/target/site/serenity/e5db22cb2edabdbe283e5dd9ab9cbb495b60f6c3ea8d1e95c2c9ad48a1236f45.html">Serenity Report</a> |

**Description**

<table border="1" cellpadding="5" cellspacing="5">
<tr>
    <th>❌ Current situation</th>
    <td>The service allows You to save data for nonexistent satellite, returning a 200 (ok) http status and success message.</td>
    </tr>
<tr>
    <th>✅ Expected situation</th>
    <td>The service must prevent saving data for nonexistent satellite and return a 404 (not found) http status.</td>
</tr>
<tr>
    <th>👩🏽‍💻 How to reproduce it</th>
    <td>Query the service using an this data. {"satellite":"vader", "distance": "142.5", "message": ["", "este", "es", "un", "mensaje"]}
    </td>
</tr>
</table>