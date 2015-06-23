require 'union-find'
require 'benchmark'

big_num = 20000000

describe 'My first pass at UF' do

  it 'can create unions and find connections' do
    qf = UF.new 20
    qf.union 5, 10
    qf.union 10, 6
    qf.union 7, 10
    qf.union 5, 7
    expect(qf.connected? 5, 10).to be true
    expect(qf.connected? 5, 6).to be true
    expect(qf.connected? 7, 6).to be true
    expect(qf.connected? 6, 7).to be true

    # So slow not worth benchmarking!

  end
end

require 'quick-find'

describe 'Quick Find' do
  xit 'can create unions and find connections' do
    qf = QuickFindUF.new 20
    qf.union 5, 10
    qf.union 10, 6
    qf.union 7, 10
    qf.union 5, 7
    expect(qf.connected? 5, 10).to be true
    expect(qf.connected? 5, 6).to be true
    expect(qf.connected? 7, 6).to be true
    expect(qf.connected? 6, 7).to be true

    measured = QuickFindUF.new(big_num)

    puts "QF Union Times"
    puts "==========="
    puts Benchmark.measure {
      (big_num / 4).times do
        a = rand(big_num)
        b = rand(big_num)
        measured.union a, b
      end
    }

    puts "QF Connected Times"
    puts "==========="
    puts Benchmark.measure {
      (big_num / 4).times do
        a = rand(big_num)
        b = rand(big_num)
        measured.connected? a, b
      end
    }
  end
end

require 'quick-union'

describe 'Quick Union' do
  it 'can create unions and find connections' do
    qu = QuickUnionUF.new 20
    qu.union 5, 10
    qu.union 10, 6
    qu.union 7, 10
    qu.union 5, 7
    expect(qu.connected? 5, 10).to be true
    expect(qu.connected? 5, 6).to be true
    expect(qu.connected? 7, 6).to be true
    expect(qu.connected? 6, 7).to be true

    measured = QuickUnionUF.new(big_num)

    puts "QU Union Times"
    puts "==========="
    puts Benchmark.measure {
      (big_num / 4).times do
        a = rand(big_num)
        b = rand(big_num)
        measured.union a, b
      end
    }

    puts "QU Connected Times"
    puts "==========="
    puts Benchmark.measure {
      (big_num / 4).times do
        a = rand(big_num)
        b = rand(big_num)
        measured.connected? a, b
      end
    }
  end
end

require 'quick-union_2'

describe 'Quick Union 2' do
  it 'can create unions and find connections' do
    qu = QuickUnionUF2.new 20
    qu.union 5, 10
    qu.union 10, 6
    qu.union 7, 10
    qu.union 5, 7
    expect(qu.connected? 5, 10).to be true
    expect(qu.connected? 5, 6).to be true
    expect(qu.connected? 7, 6).to be true
    expect(qu.connected? 6, 7).to be true

    measured = QuickUnionUF2.new(big_num)

    puts "QU2 Union Times"
    puts "==========="
    puts Benchmark.measure {
      (big_num / 4).times do
        a = rand(big_num)
        b = rand(big_num)
        measured.union a, b
      end
    }

    puts "QU2 Connected Times"
    puts "==========="
    puts Benchmark.measure {
      (big_num / 4).times do
        a = rand(big_num)
        b = rand(big_num)
        measured.connected? a, b
      end
    }
  end
end

require 'weighted-quick-union'

describe 'Weighted Quick Union' do
  it 'can create unions and find connections' do
    qu = WeightedQU.new 20
    qu.union 5, 10
    qu.union 10, 6
    qu.union 7, 10
    qu.union 5, 7
    expect(qu.connected? 5, 10).to be true
    expect(qu.connected? 5, 6).to be true
    expect(qu.connected? 7, 6).to be true
    expect(qu.connected? 6, 7).to be true

    measured = WeightedQU.new(big_num)

    puts "WQU Union Times"
    puts "==========="
    puts Benchmark.measure {
      (big_num / 4).times do
        a = rand(big_num)
        b = rand(big_num)
        measured.union a, b
      end
    }

    puts "WQU Connected Times"
    puts "==========="
    puts Benchmark.measure {
      (big_num / 4).times do
        a = rand(big_num)
        b = rand(big_num)
        measured.connected? a, b
      end
    }
  end
end