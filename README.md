# How you can perform/Understand the Structure

create a maven project add (Spring Data Redis Access + Driver), spring web and spring boot dev tools (optional), jedis (https://mvnrepository.com/artifact/redis.clients/jedis) as your dependencies.

Create a model class (refer my model for better understanding).
Create a package for redis configuration in which we have to configure

JedisConnectionFactory bean (uses jedis client library and create and maintain connection between your redis server and application).

RedisTemplate which have String as a key and values will be our model class(note that we are using redis hash which can store multiple values for a same key, optional read: data in redis is stored in key value pair)
RT is like a DAO for handling all your plumbing

1 set the connection factory
2 set the redis key serializer
3 set the redis value serializer
4 set the redis Hash key serializer
5 set the redis Hash value serializer
(2-5 steps are responsible for storing the data in redis in human readble format as redis stores the data in binary format).


coming to the service class we have a HashForOperations which will let you store data under a single key like a map.(key then hash field and hash values)

store and retrieve logic is written in the service class.
create a controller autowire service and hit the endpoints and..enjoy? :)

Important : Run the redis server and if your redis is not running on the default port which is `localhost:6379` you have to configure it as in our code the jedis connection factory bean is there the ConfigClass.jFactory() method will specify the host and port and connect to the redis automatically.

Redis stores in Hash Field and Hash Values but the serializers we have applied will get the data in the respected object only when we retrieve it.
