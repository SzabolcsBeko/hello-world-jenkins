# Start with an official Jenkins image as the base image
FROM jenkins/jenkins:lts

# Install dependencies: Git, Maven, and Java 17
USER root

# Update the apt package index and install Git, Maven, and Java 17
RUN apt-get update && \
    apt-get install -y \
    git \
    maven \
    openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*

# Set environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# Set the Maven home environment variable
ENV MAVEN_HOME=/usr/share/maven

# Add Maven and Java bin directories to the PATH
ENV PATH="${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}"

# Verify the installations (optional)
RUN java -version && \
    mvn -version && \
    git --version

# Switch back to the Jenkins user
USER jenkins

# Expose Jenkins default port
EXPOSE 8080

# Start Jenkins
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/jenkins/jenkins.war"]
