package com.redis.operationsTest;

import org.specs2._
import com.redis._
import com.redis.helpers._

import org.specs2.mock.Mockito
import org.mockito.Mock._
import org.mockito.Mockito._
import org.specs2.mutable.BeforeAfter
//import com.redis.helpers.RedisTestClient
import org.specs2.mutable.Specification
import redis.embedded.RedisServer
import org.specs2.specification.BeforeAll
import org.specs2.specification.AfterAll
import org.specs2.specification.BeforeEach

//import ai.grakn.redismock.RedisServer

object OperationsSpec extends Specification with Mockito with BeforeAll with AfterAll with BeforeEach {

	/*trait Context extends BeforeAfter {
    def before: Any = println("Doing setup")
    def after: Any = println("Done. Cleanup")
  }*/

  //"Redis Client Operations" should {

	var client: RedisTestClient = null
  var connection: Connection = null
  var server: RedisServer = null
  var client1:Redis=null

  def beforeAll() = {
    // server = RedisServer.newRedisServer();
  //  server = new RedisServer(6379); // bind to a random port
 //   server.start();

  }

  def afterAll() = {
   // server.stop();
   // server = null;
  }

  def before = {

    //  connection = mock[Connection]
     client1 = new Redis("localhost", 6379)
   // Connection=client1.connection
    // server.get
    client = new RedisTestClient(client1.connection)
    //client
  }

  /* doBefore{
      connection = mock[Connection]
      client = new RedisTestClient(connection)
    }*/

  "Redis Client Set Operations" should {
    "set a key" in {
      // client.connection.readBoolean returns true
      client.set("a", "b") mustEqual true
      
      //client.connection.write("SET a 1\r\nb\r\n") was called
    }
  }

  /* "set a key with setKey" in {
      connection.readBoolean returns true
      client.setKey("a", "b") mustEqual true
      connection.write("SET a 1\r\nb\r\n") was called
    }

    "set a key with expiration" in {
      connection.readBoolean returns true
      client.set("a", "b", 4) mustEqual true
      connection.write("SET a 1\r\nb\r\n") was called
      connection.write("EXPIRE a 4\r\n") was called
    }

    "expire a key" in {
      connection.readBoolean returns true
      client.expire("a", 4) mustEqual true
      connection.write("EXPIRE a 4\r\n") was called
    }

    "get a key" in {
      connection.readResponse returns Some("b")
      client.get("a") mustEqual Some("b")
      connection.write("GET a\r\n") was called
    }

    "get and set a key" in {
      connection.readResponse returns Some("old")
      client.getSet("a", "new") mustEqual Some("old")
      connection.write("GETSET a 3\r\nnew\r\n") was called
    }

    "delete a key" in {
      connection.readBoolean returns true
      client.delete("a") mustEqual true
      connection.write("DEL a\r\n") was called
    }

    "tell if a key exists" in {
      connection.readBoolean returns true
      client.exists("a") mustEqual true
      connection.write("EXISTS a\r\n") was called
    }

    "tell if a key exists" in {
      connection.readBoolean returns true
      client.exists("a") mustEqual true
      connection.write("EXISTS a\r\n") was called
    }

    "increment a value" in {
      connection.readInt returns Some(1)
      client.incr("a") mustEqual Some(1)
      connection.write("INCR a\r\n") was called
    }

    "increment a value by N" in {
      connection.readInt returns Some(27)
      client.incr("a", 23) mustEqual Some(27)
      connection.write("INCRBY a 23\r\n") was called
    }

    "decrement a value" in {
      connection.readInt returns Some(0)
      client.decr("a") mustEqual Some(0)
      connection.write("DECR a\r\n") was called
    }

    "decrement a value by N" in {
      connection.readInt returns Some(25)
      client.decr("a", 2) mustEqual Some(25)
      connection.write("DECRBY a 2\r\n") was called
    }

    "return type of key" in {
      connection.readResponse returns Some("String")
      client.getType("a") mustEqual Some("String")
      connection.write("TYPE a\r\n") was called
    }

    "return the ttl of a key" in {
      connection.readInt returns Some(19)
      client.ttl("a") mustEqual Some(19)
      connection.write("TTL a\r\n") was called
    }
  }*/
  //}
}

