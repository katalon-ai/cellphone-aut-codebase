type TrueTestApi = {
	setSessionAttributes?: (attributes: Record<string, string>) => void;
};

type GlobalWithTrueTest = typeof globalThis & {
	TrueTest?: TrueTestApi;
};

export function setTrueTestSessionAttributes(attributes: Record<string, string>) {
	const {TrueTest} = globalThis as GlobalWithTrueTest;
	if (TrueTest?.setSessionAttributes) {
		TrueTest.setSessionAttributes(attributes);
	}
}
