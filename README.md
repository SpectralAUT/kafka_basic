# Apache Kafka
================

Apache Kafka is a distributed streaming platform that is used to build real-time data pipelines and streaming apps. It is horizontally scalable, fault-tolerant, and runs in production in thousands of companies.

## Getting Started

### 1. Download and install Kafka

You can download the latest version of Apache Kafka from the [official website](http://kafka.apache.org/downloads). Once you have downloaded the package, you can extract it and navigate to the Kafka directory.


'''

wget https://downloads.apache.org/kafka/3.4.0/kafka_2.12-3.4.0.tgz
tar xzf kafka_2.12-3.4.0.tgz 
sudo mv kafka_2.12-3.4.0 /usr/local/kafka
nano /etc/systemd/system/zookeeper.service
sudo systemctl status kafka

'''

### Docker pull

docker pull apache/kafka:3.7.0
docker run -p 9092:9092 apache/kafka:3.7.0


### 2. Start Zookeeper and Kafka

Before you can start using Kafka, you need to start Zookeeper, which is a service that Kafka uses for storing and managing data. You can start Zookeeper by running the following command: