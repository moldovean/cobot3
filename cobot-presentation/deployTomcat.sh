#!/bin/bash
cp target/cobot.war target/ROOT.war
rsync target/ROOT.war cobot@vrabie.net:/home/cobot/Programs/apache-tomcat-8.5.6/webapps