document.addEventListener('DOMContentLoaded', function() {
    const addProductBtn = document.getElementById('addProductBtn');
    const productCardsContainer = document.getElementById('productCardsContainer');
    const contactForm = document.getElementById('contactForm');
    const vendorDescriptionForm = document.getElementById('vendorDescriptionForm');

    addProductBtn.addEventListener('click', function() {
      const cardTemplate = `
        <div class="card mb-3" style="max-width: 540px;">
          <div class="row g-0">
            <div class="col-md-4">
              <img src="images/priceTag.png" class="image1" alt="Product Photo">
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <form>
                  <div class="mb-3">
                    <label for="productName" class="form-label">Product Name</label>
                    <input type="text" class="form-control" id="productName">
                  </div>
                  <div class="mb-3">
                    <label for="productDescription" class="form-label">Product Description</label>
                    <textarea class="form-control" id="productDescription" rows="3"></textarea>
                  </div>
                  <div class="mb-3">
                    <label for="productPrice" class="form-label">Product Price</label>
                    <input type="text" class="form-control" id="productPrice">
                  </div>
                  <button type="button" class="btn btn-outline-primary add-product-btn">Add to Your Market</button>
                  <button type="button" class="btn btn-outline-danger remove-product-btn">Remove Product</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      `;
      const cardFragment = document.createRange().createContextualFragment(cardTemplate);
      productCardsContainer.appendChild(cardFragment);

      // Attach remove product button
      const removeProductBtns = document.querySelectorAll('.remove-product-btn');
      removeProductBtns.forEach(btn => {
        btn.addEventListener('click', function() {
          removeFromMarket();
          btn.closest('.card').remove();
        });
      });

      // Attach add product button
      const addProductBtns = document.querySelectorAll('.add-product-btn');
      addProductBtns.forEach(btn => {
        btn.addEventListener('click', function() {
          addToMarket();
          // Get input values
          const productName = btn.closest('.card-body').querySelector('#productName').value;
          const productDescription = btn.closest('.card-body').querySelector('#productDescription').value;
          const productPrice = btn.closest('.card-body').querySelector('#productPrice').value;

          // Do something with the input values (ie. add to database of available products for a given user?¿)
          console.log('Product Name:', productName);
          console.log('Product Description:', productDescription);
          console.log('Product Price:', productPrice);
        });
      });
    });

    // Prevent form submission
    contactForm.addEventListener('submit', function(event) {
      event.preventDefault();
    });

     // Prevent form submission
  vendorDescriptionForm.addEventListener('submit', function(event) {
      event.preventDefault();
    });

    function addToMarket() {
      $('#marketAddModal').modal('show');
    }

    function removeFromMarket() {
      $('#marketRemoveModal').modal('show');
    }

  });

  function editVendor() {
    $('#vendorModal').modal('show');
  }