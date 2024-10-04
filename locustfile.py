from locust import HttpUser, task
import random
import string

class StockTestUser(HttpUser):
    
    @task(2)
    def createQuote(self):
        print("Sending create quote request")
        response = self.client.post("/api/v1/quote", json=self.getQuote())
        print(response.status_code)

    @task(2)
    def createOption(self):
        print("Sending create option request")
        response = self.client.post("/api/v1/option", json=self.getOption())
        print(response.status_code)

    @task(3)
    def cacheQuote(self):
        print("Sending cache quote request")
        response = self.client.post("/api/v1/quote/cache", json=self.getQuote())
        print(response.status_code)

    @task(1)
    def uploadOptions(self):
        print("Sending upload options request")
        attach = open('options.csv', 'rb')
        response = self.client.post("/api/v1/option/upload", files={'file': attach})
        print(response.status_code)

    def getQuote(self):
        return {
            "company" : self.getRandomString(10),
            "ticker": self.getRandomString(3),
            "stockExchange": self.getRandomString(6),
            "quotePrice": random.randrange(100, 200),
            "previousClose": random.randrange(100, 200),
            "dailyChange": random.randrange(-10, 10),
            "dailyChangePercent": random.randrange(1, 4),
            "open": random.randrange(100, 200),
            "bid": random.randrange(100, 170),
            "ask": random.randrange(100, 180),
            "volume": random.randrange(10000, 50000),
        }
    
    def getOption(self):
        return {
        "callOptionPrice" : random.randrange(50, 200),
        "currentStockPrice" : random.randrange(80, 160),
        "strikePrice" : random.randrange(100, 200),
        "riskFreeInterestRate": random.randrange(1, 5),
        "timeToMaturity": random.randrange(6, 12)
    }
    
    def getRandomString(self, length):
        letters = string.ascii_lowercase
        result_str = ''.join(random.choice(letters) for i in range(length))
        return result_str




