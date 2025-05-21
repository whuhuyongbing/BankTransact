Instructions to the Candidate for the home task

Create a simple application related to transaction management within a banking system. The application should enable users to record, view, and manage financial transactions. User authentication is not required for this task. You are expected to complete this task independently and can use any resources or reference materials you consider helpful. The completed work should be submitted via email or a public Github repository within 48 hours of receiving this assignment. The task should take approximately 1 to 2 hours to complete. After receiving the submission, we will schedual a follow-up discussion.

Intructions:
1. write in Java 21 and springboot.
2. the primary entity is the transaction.
3. all data should be held in memory, no persistent storage is necessary.
4. Key points to address are:
    clear and well-structured API
    Emphasis on performance for all core operations
    containerization with tools like Docker, Kubernetes
    Implement caching mechanisms where applicable
    Robust validation and exception handling
    Efficient data queries and pagination
    Follow Restful API design principles

5. Deliverable should be a stand-alone project that is straightforward to run and test.
6. use Maven for probject management
7. if you use external libraries outside the standard JDK, list them in the README and explain their purpuse.
8. Ensure page functionalities: adding, modifying, deleting transactions, displaying the transation list on the page.

API to implement:
Design your funcations with clear action descript
ions.

1. create transaction
2. delete transaction
3. modify transaction
4. List all transacions
5. Implement error handling for scenarios such as creating duplicate transactions or deleting a non-existent transaction
6. perform unit testing on the API to ensure robustness and reliability
7. If relevant, handle and test the logic for transaction types or categories
8. Ensure the API can withstand stress tests and maintain performance under load


