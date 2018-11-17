package com.redis

import org.specs2._

import com.redis._

import org.specs2.mock.Mockito
import org.mockito.Mock._
import org.mockito.Mockito._
import org.mockito.Mockito.doNothing

object RedisClientSpec extends Specification with Mockito {

  /*def is = s2"""

 This is a specification to check the 'Hello world' string

 The 'Hello world' string should
   contain 11 characters                                         $e1
   start with 'Hello'                                            $e2
   end with 'world'                                              $e3
                                                                 """

  def e1 = "Hello world" must have size (11)
  def e2 = "Hello world" must startWith("hHello")
  def e3 = "Hello world" must endWith("world")*/
  
  def is=s2"""
   This is  to check the Redis Client
    print formatted client status $redisclientString 
    """
   
    var client: Redis = null

   def redisclientString = {
		  client = new Redis("localhost", 6379)
		  println("addd"+client.toString())
		  client.toString must beMatching ("localhost:6379 <connected:true>")
  }
    

   /*"Redis Client" should {
    var client: Redis = null
    
   "print formatted client status" in {
      client = new Redis("localhost", 121212)
      client.toString must be matching("localhost:121212 <connected:false>")
    }
    
    "get the same connection when passing key para or not since it's a single node" in {
      client.getConnection("key") mustEqual client.getConnection
    }
    
    "use db zero as default" in {
      client.db mustEqual 0
    }
  }*/
}
