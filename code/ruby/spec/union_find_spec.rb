require 'union-find'

describe 'My first pass at UF' do
  it 'can create unions and find connections' do
    qf = UF.new 20
    qf.union 5, 10
    expect(qf.connected? 5, 10).to be true
    expect(qf.connected? 5, 6).to be false
  end
end

require 'quick-find'

describe 'Quick Find' do
  it 'can create unions and find connections' do
    qf = QuickFindUF.new 20
    qf.union 5, 10
    expect(qf.connected? 5, 10).to be true
    expect(qf.connected? 5, 6).to be false
  end
end

require 'quick-union'

describe 'Quick Union' do
  it 'can create unions and find connections' do
    qf = QuickUnionUF.new 20
    qf.union 5, 10
    expect(qf.connected? 5, 10).to be true
    expect(qf.connected? 5, 6).to be false
  end
end