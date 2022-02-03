FROM tomcat:8.5.75
ADD target/untitled.war /usr/local/tomcat/webapps/untitled.war
EXPOSE 8080
CMD ["catalina.sh", "run"]