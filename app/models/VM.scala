package models

/**
 * State of VM
 */
object VMState extends Enumeration {
  type VMState = Value
  val Running, Stopped, Unknown = Value
}

import VMState._

/**
 * Virtual Machine
 * 
 * @param id ID
 * @param name VM name
 * @param state VM state
 */
case class VM(id: Int, name: String, state: VMState)

/**
 * Virtual Machine Service
 */
object VM {
  /**
   * Retrieve all VMs.
   * 
   * @return VMs
   */
  def list() = List(
    VM(1, "hoge", Running),
    VM(2, "huga", Stopped),
    VM(3, "piyo", Unknown))
      
}