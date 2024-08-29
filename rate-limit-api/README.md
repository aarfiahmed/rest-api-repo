# rate-limit-api

# Dependency
* bucket4j-core

# How the Token Bucket Algorithm Works
1. Basic Concepts
   Bucket: Imagine a bucket that can hold a fixed number of tokens.
   Tokens: Each token represents permission to send a certain amount of data or process a request. For example, one token might allow one HTTP request or one packet of data to be sent.
   Token Generation: Tokens are added to the bucket at a constant rate, up to a maximum capacity. If the bucket is full, additional tokens are discarded.
2. Operation
   Request Handling: When a request is made (e.g., to send data or process an API call), a token is removed from the bucket.
   Insufficient Tokens: If there are no tokens in the bucket when a request arrives, the request is either delayed until a token is available (in a leaky bucket variant) or rejected (in a strict implementation).
   Token Replenishment: Tokens are replenished over time at a fixed rate, simulating a steady flow of allowed operations.
   Example Scenario
   Consider an API that wants to limit the number of requests from a user to 5 requests per minute. Here's how the Token Bucket algorithm would manage this:

Bucket Capacity: The bucket can hold a maximum of 5 tokens.
Token Refill Rate: Tokens are added to the bucket at a rate of 1 token every 12 seconds (to total 5 tokens per minute).
Request Handling: Each incoming API request consumes one token from the bucket.
If a user makes a request and tokens are available, the request is processed, and one token is removed.
If no tokens are available, the request is either delayed or denied until tokens become available.


# Terminology
Before we look at how to use Bucket4j, we’ll briefly discuss some of the core classes, and how they represent the different elements in the formal model of the token-bucket algorithm.

The Bucket interface represents the token bucket with a maximum capacity. It provides methods such as tryConsume and tryConsumeAndReturnRemaining for consuming tokens. These methods return the result of consumption as true if the request conforms with the limits, and the token was consumed.

The Bandwidth class is the key building block of a bucket, as it defines the limits of the bucket. We use Bandwidth to configure the capacity of the bucket and the rate of refill.

The Refill class is used to define the fixed rate at which tokens are added to the bucket. We can configure the rate as the number of tokens that would be added in a given time period. For example, 10 buckets per second or 200 tokens per 5 minutes, and so on.