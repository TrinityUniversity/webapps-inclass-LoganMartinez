console.log("hello")

function incrementCounter() {
  fetch("/incrementCounter", {
    method: "POST",
    headers: {"Content-Type": "application/x-www-form-urlencoded"}
  }).then(res => 
    res.text().then(count =>
        document.getElementById("count").innerHTML = count)
      
      )
    
    
    
}