import {useRouter} from 'next/router';
import {StarterWrapper, startOrderInfo} from 'boundless-checkout-react';
import {apiClient} from '../../lib/api';
import MainLayout from '../../layouts/Main';
import {GetStaticPaths, GetStaticProps} from 'next';
import {makeAllMenus} from '../../lib/menu';
import {IMenuItem} from '../../@types/components';
import {useCallback, useMemo, useRef} from 'react';

export default function ThankYouPage({mainMenu, footerMenu}: IProps) {
	const router = useRouter();
	const checkoutStarter = useRef<StarterWrapper>();
	const orderId = useMemo(() => {
		if (typeof router.query.id === 'string' && router.query.id !== 'demo') {
			return router.query.id;
		}

		const pathOrderId = router.asPath.split('?')[0].split('/').filter(Boolean).pop();
		return pathOrderId && pathOrderId !== 'thank-you' ? pathOrderId : null;
	}, [router.asPath, router.query.id]);

	const checkoutRef = useCallback((node: HTMLDivElement) => {
		if (node && orderId) {
			checkoutStarter.current = startOrderInfo(node, {
				orderId,
				api: apiClient,
				onError: (error) => console.error('order info error:', error)
			});
		}
	}, [orderId]);

	if (!orderId) {
		return null;
	}

	return (
		<MainLayout title={'Thank you for your order!'}
								mainMenu={mainMenu}
								footerMenu={footerMenu}
								noIndex
		>
			<div className={'container'}>
				<h1 className='page-heading page-heading_h1  page-heading_m-h1'>Thank you for your order!</h1>
				<div ref={checkoutRef} />
			</div>
		</MainLayout>
	);
}

export const getStaticPaths: GetStaticPaths = async () => ({
	paths: [{params: {id: 'demo'}}],
	fallback: 'blocking'
});

export const getStaticProps: GetStaticProps<IProps> = async () => {
	const categoryTree = await apiClient.catalog.getCategoryTree({menu: 'category'});
	const {mainMenu, footerMenu} = makeAllMenus({categoryTree});

	return {
		props: {
			mainMenu,
			footerMenu
		}
	};
};

interface IProps {
	mainMenu: IMenuItem[];
	footerMenu: IMenuItem[];
}
