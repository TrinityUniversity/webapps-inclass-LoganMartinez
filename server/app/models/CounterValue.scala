package models
import java.util.concurrent.atomic.AtomicInteger

object CounterValue {
  var value = new AtomicInteger(0)
  def increment() = value.addAndGet(1)
  def get() = value.get()
}
