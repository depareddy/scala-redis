package com.redis.util

import com.redis.Redis

object Test {
  
  
   def main(args: Array[String]) {
     
      val client = new Redis("localhost", 6379)
      client.set("d", "1")
      
      print(client.get("d"))
      
      client.incrBy("d", 6)
      
      print(client.get("d"))
      
      print(client.decr("d", 4))
     
     
   }
  
  
  
}