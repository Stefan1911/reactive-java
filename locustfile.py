from locust import HttpUser, task

class StockQuoteTestUser(HttpUser):

    ##wait_time = between(1, 3)

    @task
    def hello_world(self):

        jsonBody = {
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

        response = self.client.post("/api/v1/quote", json=jsonBody)
        print(response)

