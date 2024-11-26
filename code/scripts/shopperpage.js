//JS fuction to repeat certain code blocks            
function codeBlockProduct(blocknum) {
	var container = document.getElementById('repeated-blocks-product')
	var html = '';
	for (var i = 1; i <= blocknum; i++) {
		html += `
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="..." class="img-fluid rounded-start" alt="Photo of Product">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">Example Product</h5>
							<p class="card-text">Description....</p>
							<p class="card-text"><small class="text-body-secondary">Vendor: ....</small></p>
						</div>
					</div>
				</div>
			</div>

		`;
	}
	container.innerHTML = html;
}

document.addEventListener('DOMContentLoaded', function () {
	codeBlockProduct(5);
});


//JS fuction to repeat certain code blocks            
function codeBlockVendor(blocknum) {
	var container = document.getElementById('repeated-blocks-vendor')
	var html = '';
	for (var i = 1; i <= blocknum; i++) {
		html += `
			<div class="card mb-3 featured-product" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="images/vendor2.png" class="img-fluid rounded-start" alt="Vendor Profile Picture">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">Example Vendor</h5>
							<p class="card-text">Location: ...</p>
							<p class="card-text">Contact Information: ....</p>
							<p class="card-text">Description: ...</p>
						</div>
					</div>
				</div>
			</div>        

		`;
	}

	container.innerHTML = html;
}

document.addEventListener('DOMContentLoaded', function () {
	codeBlockVendor(4);
});






function execute1() {
	productImage = document.getElementById("pI1").getAttribute('src');
	productTitle = document.getElementById("pT1").innerHTML;
	productVendor = document.getElementById("pV1").innerHTML;
	productDesc = document.getElementById("pD1").innerHTML;

	let product1 = {
		image: productImage,
		title: productTitle,
		descrip: productDesc,
		vendor: productVendor
	};

	window.localStorage.setItem('products', JSON.stringify(product1));
}


function execute2() {
	productImage = document.getElementById("pI2").getAttribute('src');
	productTitle = document.getElementById("pT2").innerHTML;
	productVendor = document.getElementById("pV2").innerHTML;
	productDesc = document.getElementById("pD2").innerHTML;

	let product2 = {
		image: productImage,
		title: productTitle,
		descrip: productDesc,
		vendor: productVendor
	};

	window.localStorage.setItem('products', JSON.stringify(product2));
}


function execute3() {
	productImage = document.getElementById("pI3").getAttribute('src');
	productTitle = document.getElementById("pT3").innerHTML;
	productVendor = document.getElementById("pV3").innerHTML;
	productDesc = document.getElementById("pD3").innerHTML;

	let product3 = {
		image: productImage,
		title: productTitle,
		descrip: productDesc,
		vendor: productVendor
	};

	window.localStorage.setItem('products', JSON.stringify(product3));
}


function execute4() {
	productImage = document.getElementById("pI4").getAttribute('src');
	productTitle = document.getElementById("pT4").innerHTML;
	productVendor = document.getElementById("pV4").innerHTML;
	productDesc = document.getElementById("pD4").innerHTML;

	let product4 = {
		image: productImage,
		title: productTitle,
		descrip: productDesc,
		vendor: productVendor
	};

	window.localStorage.setItem('products', JSON.stringify(product4));
}
