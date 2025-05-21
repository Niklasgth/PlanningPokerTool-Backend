<h1>Planning Poker Tool – Backend</h1>
 <p><strong>Tech Stack:</strong> Spring Boot + Java + MongoDB</p> 
 <p>This is the backend API for the Planning Poker Tool. It exposes endpoints for users, tasks, and estimates using REST with JSON.</p>
  <hr>
<h2>What’s included</h2>
 <ul>
  <li>Spring Boot (REST API)</li>
   <li>Maven for dependency management</li>
    <li>MongoDB via Spring Data</li>
     <li>Cross-Origin Resource Sharing (CORS) enabled for frontend</li>
      </ul>
    <hr>
     <h2>Getting Started</h2>
      <h3>1. Requirements</h3>
       <ul>
        <li>Java 17 or later</li>
         <li>Maven</li>
          <li>MongoDB (local or remote)</li>
           </ul>
            <h3>2. Clone the project</h3>
             <pre><code>git clone [REPO_URL]</code></pre>
              <h3>3. Configure environment</h3>
               If needed, change MongoDB connection in: <pre><code>src/main/resources/application.properties</code></pre>
                 <h3>4. Build & Run the app</h3>
                  <pre><code>./mvnw spring-boot:run</code></pre>
                   or with Maven installed: <pre><code>mvn spring-boot:run</code></pre>
                    <h3>5. Backend will start on:</h3>
                     <pre><code>http://localhost:8080/api</code></pre>
                      <hr>
                       <h2>Project Structure Overview</h2>
                        <pre> src/ ├── controller/ → REST endpoints (UserController, TaskController) ├── model/ → Data models (User, Task, Estimate) ├── repository/ → MongoDB Repositories ├── service/ → Business logic └── ... </pre>
                         <hr>
                          <h2>API Endpoints</h2>
                           <h3>Users</h3>
                            <ul>
                             <li>
                             <code>GET /api/users</code>
                             </li>
                              <li>
                              <code>POST /api/user</code>
                              </li>
                               </ul>
                                <h3>Tasks</h3>
                                 <ul>
                                  <li>
                                  <code>GET /api/tasks</code>
                                  </li>
                                   <li>
                                   <code>GET /api/task/{id}</code>
                                   </li>
                                    <li>
                                    <code>POST /api/task</code>
                                    </li>
                                     </ul>
                                      <h3>Estimates</h3>
                                       <ul>
                                        <li>
                                        <code>POST /api/task-estimate</code>
                                        </li>
                                         <li>
                                         <code>GET /api/task-estimates/{taskId}</code>
                                         </li>
                                          </ul>
                                           <hr>
                                            <h2>CORS Configuration</h2>
                                             CORS is enabled in your configuration to allow frontend requests (http://localhost:5173). 
                                            <hr>
                                             <h2>MongoDB Notes</h2>
                                              Make sure MongoDB is running: <pre><code>mongod</code></pre> Check your collections with: <pre><code>mongo use planningpoker show collections </code></pre>
                                                <hr>
                                                 <h2>Production Notes</h2>
                                                  If deployed, update the frontend `.env` file: <pre><code>MONGO_URI=mongodb+srv://timepoker_user:CDx4Y4g3QcpUK4S@cluster0.gtv9ppl.mongodb.net/?retryWrites=true&w=majority&appName=timepoker-backend
                                                    JWT_SECRET=timepokerKey1
                                                    SERVER_PORT=8080</code></pre> <hr>
                                                   <h2>Build for Production</h2> <pre><code>mvn clean install</code></pre>