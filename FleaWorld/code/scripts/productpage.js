function getProductInformation(pImage, pTitle, pDescription, pVendor){

    productImage = document.getElementById(pImage);
    productTitle = document.getElementById(pTitle);
    productDescription = document.getElementById(pDescription);
    productVendor = document.getElementById(pVendor);

    let product = {

        image: productImage,
        title: productTitle,
        description: productDescription,
        vendor: productVendor


    };

    localStorage.setItem(products, JSON.stringify(product));

}

function fillProductPage(){

  product = JSON.parse(localStorage.getItem('products'));

  console.log(product)

  image = product['image'];
  title = product['title'];
  description = product['descrip'];
  vendor = product['vendor'];

  console.log(image);


  var container = document.getElementById('productPageFill');
  var html = '';
  html +=   `
<div class="card-group">
<div class="card">


  <div class="container">
    <div class="row">
      <div class="col-md-4">

        <!-- This is the space for the card on the left -->
        <div class="card">
          <div class="card-body">
            <div class="text-center">
              <h3 class="card-title">${title}</h3>
            </div>
            <div class="card mb-3" style="max-width: 540px;">
              
              <div class="row g-0">
                <div class="col-md-8">
                  <div class="card-body">
                    <div class="text-center">
                      <img src=${image} alt="slideshow" width="150%" height="70%">
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
      <div class="col-md-8">
      <div class="card mb-3">
        <div class="card-body">
          <h5 class="card-title">${title} ----- ${vendor}</h5>
          <p class="card-text">${description}</p>
          
          <div class="row g-0" style="padding: 160px 0;"></div>
          <p class="card-text"><small class="text-muted">Last updated: 1 month ago</small></p>
        </div>
          
          <div class="card-footer">
        

        <!-- Button Add to Favorites modal --Triggers Popup -->
        <!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
          Add to Favorites
        </button> -->
        <button id="button9" type="button" class="btn btn-primary" onclick="addToFavorites('${title}', '${vendor}', '${image}')">Add to Favorites</button>
        <button id="button10" type="button" class="btn btn-primary" onclick="addToCart('${title}', '${vendor}', '${image}')">Add to Cart</button>

        </div>
      </div>
    </div>
    `
  container.innerHTML = html;
}

function addToFavorites(productName, vendorName) {
  let favorites = JSON.parse(localStorage.getItem('favorites')) || [];
  favorites.push({
    productName,
    vendorName
  });
  localStorage.setItem('favorites', JSON.stringify(favorites));
  
  // Show modal
  $('#favsModal').modal('show');

}

function addToCart(productName, vendorName) {
  console.log('addToCart function is being called.');
  let cart = JSON.parse(localStorage.getItem('cart')) || [];
  cart.push({
    productName,
    vendorName
  });
  localStorage.setItem('cart', JSON.stringify(cart));

  // Show modal
  $('#cartModal').modal('show');

}