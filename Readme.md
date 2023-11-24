## Déploiement

### Via Docker

S'assurer d'avoir un container docker en marche du nom de 'rabbitmq' et déployé avec un réseau du nom de 'rabbitmq_network'.

Pour créer le network vous pouvez le faire de la manière suivante dans un terminal :

    $ docker network create rabbitmq_network

Pour créer un container docker avec rabbitmq sur ce network, procédez avec la commande suivante :

    $ docker run --rm -it --network rabbitmq_network -p 15672:15672 -p 5672:5672 rabbitmq:3.12.9-management

Attention pensez à rajouter à la commande le --name rabbitmq et le --hostname rabbitmq !

Puis faire la commande suivante : docker-compose up --build


S'assurer également d'avoir un container mailhog qui tourne également sur ce network avec l'hostname mailhog, sur le port 1025, vous pouvez le créer avec la commande suivante :
    
    docker run -d --network rabbitmq_network --name mailhog --hostname mailhog -e "MH_STORAGE=maildir" -v $PWD/maildir:/maildir -p 1025:1025 -p 8025:8025 mailhog/mailhog
## Utilisation

Une fois le message reçu de la part de rabbitmq, vous pouvez allez sur http://localhost:8025/ pour constater la bonne réception du mail.