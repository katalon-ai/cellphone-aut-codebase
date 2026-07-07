import {
	TRUETEST_PLAYWRIGHT_SOURCE,
	expect,
	test,
} from './support/storefront';

test.describe('TrueTest session tagging', () => {
	test('sets the Playwright source session attribute when TrueTest is available', async ({page}) => {
		const html = `
			<!doctype html>
			<script>
				window.TrueTest = {
					setSessionAttributes(attributes) {
						window.__trueTestSessionAttributes = attributes;
					}
				};
			</script>
		`;

		await page.goto(`data:text/html,${encodeURIComponent(html)}`);

		await expect.poll(
			() => page.evaluate(() => {
				const win = window as typeof window & {
					__trueTestSessionAttributes?: Record<string, string>;
				};
				return win.__trueTestSessionAttributes?.source;
			}),
			{message: 'Expected Playwright sessions to be tagged for TrueTest'}
		).toBe(TRUETEST_PLAYWRIGHT_SOURCE);
	});
});
