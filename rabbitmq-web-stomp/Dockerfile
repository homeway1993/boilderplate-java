FROM rabbitmq:management

RUN rabbitmq-plugins enable --offline rabbitmq_web_stomp rabbitmq_web_stomp_examples

# expose stomp port
EXPOSE 61613

# expost web-stomp port
EXPOSE 15674

# expost web-stomp-example port
EXPOSE 15670