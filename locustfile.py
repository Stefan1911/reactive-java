from locust import HttpUser, task

class StockTestUser(HttpUser):

    qupteJsonBody = {
        "company" : "HTEC",
        "ticker": "htc",
        "stockExchange": "masdac",
        "quotePrice": 128,
        "previousClose": 120,
        "dailyChange": 8,
        "dailyChangePercent": 3,
        "open": 123,
        "bid": 120,
        "ask": 130,
        "volume": 20
    }

    optionJsonBody = {
        "callOptionPrice" : 120,
        "currentStockPrice" : 123,
        "strikePrice" : 120,
        "riskFreeInterestRate": 120,
        "timeToMaturity": 120
    }

    @task
    def createQuote(self):
        print("Sending create quote request")
        response = self.client.post("/api/v1/quote", json=StockTestUser.qupteJsonBody)
        print(response.status_code)

    @task
    def createOption(self):
        print("Sending create option request")
        response = self.client.post("/api/v1/option", json=StockTestUser.optionJsonBody)
        print(response.status_code)

    @task
    def cacheQuote(self):
        print("Sending cache quote request")
        response = self.client.post("/api/v1/quote/cache", json=StockTestUser.qupteJsonBody)
        print(response.status_code)

    @task
    def uploadOptions(self):
        print("Sending upload options request")
        attach = open('options.csv', 'rb')
        response = self.client.post("/api/v1/option/upload", files={'file': attach})
        print(response.status_code)




