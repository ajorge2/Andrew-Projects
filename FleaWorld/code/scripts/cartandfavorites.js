function displayItems(storageKey) {
    let items = JSON.parse(localStorage.getItem(storageKey)) || [];
    let container = document.getElementById(storageKey);
    let html = '';
    let i = 0;
  
    items.forEach(item => {
      html += `
        <div class="col-md-4" style="padding: 10px;">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">${item.productName}</h5>
              <p class="card-text">${item.vendorName}</p>
            </div>
            <button onclick="removeItem('${storageKey}', ${i})" class="btn btn-outline-primary">Remove</button>
          </div>
        </div>
      `;
      i++;
    });
  
    container.innerHTML = html;
  }
  
  function removeItem(storageKey, index) {
    let items = JSON.parse(localStorage.getItem(storageKey)) || [];
    let newItems = [];
  
    for (let i = 0; i < items.length; i++) {
      if (i !== index) {
        newItems.push(items[i]);
      }
    }
  
    localStorage.setItem(storageKey, JSON.stringify(newItems));
    displayItems(storageKey);
  }
  