const defaultImage = {
	image_id: 1,
	path: '/og.jpeg',
	width: 1200,
	height: 630
};

const basicSettings = {
	'system.locale': {
		language: 'en',
		locale: 'en-US',
		money: {
			format: '%s%v',
			precision: 2,
			symbol: '$',
			decimal: '.',
			thousand: ','
		}
	},
	'system.currency': {
		alias: 'usd',
		symbol: '$',
		code: 'USD'
	}
};

const labels = [
	{
		label_id: 1,
		title: 'Demo',
		color: '#0f766e',
		text_color: '#ffffff',
		icon: 'ok'
	}
];

const categories = [
	{
		category_id: 10,
		parent_id: null,
		title: 'Phones',
		url_key: 'phones',
		custom_link: null,
		level: 0,
		image: defaultImage,
		seo: {
			title: 'Phones',
			metaDesc: 'Demo phones for the Netlify testing site.'
		},
		text: {
			description_top: '<p>Demo catalog data for testing automation flows.</p>',
			description_bottom: ''
		},
		props: {
			custom_link: null
		},
		filter: {
			fields: []
		}
	}
];

const products = [
	{
		product_id: 101,
		item_id: 1001,
		url_key: 'demo-iphone-case',
		title: 'Demo iPhone Case',
		sku: 'DEMO-IP-CASE',
		in_stock: true,
		has_variants: false,
		labels,
		default_category: categories[0],
		categoryRels: [{is_default: true, category: categories[0]}],
		images: [
			{
				is_default: true,
				image: {...defaultImage, image_id: 101},
				alt: 'Demo iPhone Case',
				description: 'Demo iPhone Case'
			}
		],
		prices: [
			{
				price_alias: 'selling_price',
				value: '29.00',
				old: '39.00',
				currency_alias: 'USD'
			}
		],
		seo: {
			title: 'Demo iPhone Case',
			metaDesc: 'A sample product for the testing site.'
		},
		text: {
			description: '<p>A mock product that lets the site build and render without a Boundless Commerce account.</p>'
		},
		attributes: [],
		manufacturer: null,
		props: {
			size: null
		}
	},
	{
		product_id: 102,
		item_id: 1002,
		url_key: 'demo-android-case',
		title: 'Demo Android Case',
		sku: 'DEMO-ANDROID-CASE',
		in_stock: true,
		has_variants: false,
		labels: [],
		default_category: categories[0],
		categoryRels: [{is_default: true, category: categories[0]}],
		images: [
			{
				is_default: true,
				image: {...defaultImage, image_id: 102},
				alt: 'Demo Android Case',
				description: 'Demo Android Case'
			}
		],
		prices: [
			{
				price_alias: 'selling_price',
				value: '24.00',
				old: null,
				currency_alias: 'USD'
			}
		],
		seo: {
			title: 'Demo Android Case',
			metaDesc: 'A second sample product for the testing site.'
		},
		text: {
			description: '<p>Another mock product for automation and deployment checks.</p>'
		},
		attributes: [],
		manufacturer: null,
		props: {
			size: null
		}
	}
];

class MockThumb {
	private imgLocalPath: string;
	private width?: number | null;
	private height?: number | null;

	constructor({imgLocalPath, originalWidth, originalHeight}: {imgLocalPath: string, originalWidth?: number, originalHeight?: number}) {
		this.imgLocalPath = imgLocalPath || '/og.jpeg';
		this.width = originalWidth;
		this.height = originalHeight;
	}

	setRatio() { return this; }
	setPad() { return this; }
	setGrayscale() { return this; }
	setBlur() { return this; }

	setOriginalSize(width?: number | null, height?: number | null) {
		this.width = width;
		this.height = height;
		return this;
	}

	getSrc() {
		return this.imgLocalPath.startsWith('/') ? this.imgLocalPath : `/${this.imgLocalPath}`;
	}

	getAttrs() {
		return {
			src: this.getSrc(),
			width: this.width || defaultImage.width,
			height: this.height || defaultImage.height
		};
	}
}

const getPagination = (length: number) => ({
	page: 1,
	pageCount: 1,
	perPage: length,
	totalEntries: length,
	total: length
});

const withCategoryRelations = (category: any) => ({
	...category,
	parents: [category],
	children: [],
	siblings: categories,
	props: category.props || {custom_link: null}
});

export const mockApiClient = {
	makeThumb: (params: any) => new MockThumb(params),
	catalog: {
		getCategoryTree: async () => categories,
		getFlatCategories: async () => categories,
		getCategoryParents: async () => categories,
		getCategoryItem: async (slug: string | number) => {
			const category = categories.find(item => item.url_key === slug || item.category_id === Number(slug));
			if (!category) {
				const error: any = new Error('Category not found');
				error.response = {status: 404};
				throw error;
			}

			return withCategoryRelations(category);
		},
		getProducts: async (query: any = {}) => {
			const pageProducts = query.category
				? products.filter(product => query.category.includes(product.default_category.category_id))
				: products;

			return {
				products: pageProducts,
				pagination: getPagination(pageProducts.length)
			};
		},
		getProduct: async (slug: string | number) => {
			const product = products.find(item => item.url_key === slug || item.product_id === Number(slug));
			if (!product) {
				const error: any = new Error('Product not found');
				error.response = {status: 404};
				throw error;
			}

			return product;
		},
		getFilterFieldsRanges: async () => ({fields: []})
	},
	system: {
		fetchSettings: async () => basicSettings
	},
	cart: {
		retrieveCart: async () => ({id: 'demo-cart', total: {qty: 0, price: '0.00'}}),
		getCartInfo: async (id: string) => ({id, total: {qty: 0, price: '0.00'}}),
		getCartItems: async () => ({items: [], total: {qty: 0, price: '0.00'}}),
		addItemToCart: async () => ({added: null, cartTotal: {qty: 1, price: '0.00'}}),
		removeFromCart: async () => ({items: [], total: {qty: 0, price: '0.00'}}),
		setCartItemsQty: async () => ({items: [], total: {qty: 0, price: '0.00'}})
	}
};
