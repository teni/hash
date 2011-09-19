from math import *
class hash_obj:
   m = 0
   def  __init__(self , s=100):
      self.m = s
   def hash_mul(self,key):

   # Multiply the key by a constant A in the range of 0 < A < 1 and extract the fractional part of KA
   # A good value for A is  sqrt(5) - 1 / 2
      A = (sqrt(5) - 1 ) / 2
      h = (key*A) % 1
      h = floor(self.m *h)
      return int(h)

   def hash_div(self,key):
      return int(key% self.m)

