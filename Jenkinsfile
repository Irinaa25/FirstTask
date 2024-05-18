{\rtf1\ansi\ansicpg1251\cocoartf2709
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 pipeline \{\
    agent any\
    \
    environment \{\
        JAVA_HOME = '/usr/local/Cellar/openjdk/21.0.3/libexec/openjdk.jdk/Contents/Home'\
        MAVEN_HOME = '/usr/local/Cellar/maven/3.9.6/libexec'\
    \}\
    \
    stages \{\
        stage("Compile code") \{\
            steps \{\
                sh '/usr/local/Cellar/maven/3.9.6/libexec/bin/mvn clean compile'\
            \}\
        \}\
        \
        stage("Tests") \{\
            when \{\
                branch 'feature/*'\
            \}\
            steps \{\
                sh '/usr/local/Cellar/maven/3.9.6/libexec/bin/mvn test'\
            \}\
        \}\
        \
        stage("Static analyse") \{\
            when \{\
                branch 'develop'\
            \}\
            steps \{\
                sh '/usr/local/Cellar/maven/3.9.6/libexec/bin/mvn checkstyle:check'\
            \}\
        \}\
        \
        stage("Report") \{\
            when \{\
                branch 'feature/*'\
            \}\
            steps \{\
                junit testResults: '**/surefire-reports/*.xml'\
                jacoco()\
            \}\
        \}\
        \
        stage("Install") \{\
            steps \{\
                sh '/usr/local/Cellar/maven/3.9.6/libexec/bin/mvn install'\
            \}\
        \}\
        \
        stage("Publish") \{\
            steps \{\
                sh 'cp main/target/main-1.0-SNAPSHOT-jar-with-dependencies.jar /Users/resetovsergej/Desktop'\
            \}\
        \}\
    \}\
\}}
